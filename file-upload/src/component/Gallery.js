import {useQuery} from "@apollo/client";
import {GET_STRING} from "../graphql/query";

const Gallery = () => {
    const {loading, error, data} = useQuery(GET_STRING);

    console.log(data);

    return (
        <div>
            <h2>Gallery</h2>
            <div>
                <p>Here will be the files displayed</p>
            </div>
        </div>
    );
}

export default Gallery;