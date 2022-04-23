import {useQuery} from "@apollo/client";
import {GET_IMAGES} from "../graphql/query";

const Gallery = () => {
    const {loading, error, data} = useQuery(GET_IMAGES);
    // if (loading) return <Loading />;
    if (error) return <p>ERROR</p>;
    if (!data) return <p>Not found</p>;

    // const imagesList = data.map(image => {
    //     return <li>{image}</li>;
    // })

    return (
        <div>
            <h2>Gallery</h2>
            <div>
                {/*<div>{ imagesList }</div>*/}
                <img src={"https://store.hp.com/app/assets/images/uploads/prod/25-best-hd-wallpapers-laptops159561982840438.jpg"}
                     alt={"Image"}
                />
            </div>
        </div>
    );
}

export default Gallery;