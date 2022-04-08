import {useQuery} from "@apollo/client";
import {GET_STRING} from "../graphql/query";

const Gallery = () => {
    const {loading, error, data} = useQuery(GET_STRING);

    console.log(data);

    return (
        <div>
            <h2>Gallery</h2>
            <div>
                <img src={"https://store.hp.com/app/assets/images/uploads/prod/25-best-hd-wallpapers-laptops159561982840438.jpg"}
                     alt={"Image"}
                />
            </div>
        </div>
    );
}

export default Gallery;