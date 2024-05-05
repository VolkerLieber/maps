import MapContext from "@rnmapbox/maps/src/web/MapContext";
import { Marker, MarkerOptions } from "mapbox-gl";
import {
    forwardRef,
    isValidElement,
    memo,
    ReactElement,
    Ref,
    useContext,
    useEffect,
    useImperativeHandle,
    useMemo
} from "react";
import { createPortal } from "react-dom";

type MarkerViewProps = {
    coordinate: [number, number];
    children?: ReactElement;
} & Omit<MarkerOptions, "element">;

function MarkerView(props: MarkerViewProps, ref: Ref<Marker>) {
    const { map } = useContext(MapContext);

    // Create marker instance
    const marker: Marker = useMemo(() => {
        const mk = new Marker({
            ...props,
            element: isValidElement(props.children)
                ? document.createElement("div")
                : undefined,
        });

        mk.setLngLat(props.coordinate as [number, number]);

        return mk;
    }, []);

    // Add marker to map
    useEffect(() => {
        if (map === undefined) {
            return;
        }

        marker.addTo(map);

        return () => {
            marker.remove();
        };
    }, [map]);

    // Expose marker instance
    useImperativeHandle(ref, () => marker, []);

    // Fix marker position
    useEffect(() => {
        const style = marker.getElement().style;
        style.position = "absolute";
        style.top = "0";
        style.left = "0";
    }, []);

    // Update marker position
    if (
        marker.getLngLat().lng !== props.coordinate[0] ||
        marker.getLngLat().lat !== props.coordinate[1]
    ) {
        marker.setLngLat([props.coordinate[0], props.coordinate[1]]);
    }

    // Inject children into marker element
    return createPortal(props.children, marker.getElement());
}

export default memo(forwardRef(MarkerView));
