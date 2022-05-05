import {useQuery} from "@apollo/client";
import {GET_IMAGES} from "../graphql/query";

const Gallery = () => {
    const {loading, error, data} = useQuery(GET_IMAGES);
    // if (loading) return <Loading />;
    if (loading) return <p>LOADING</p>;
    if (error) return <p>ERROR</p>;
    if (!data) return <p>Not found</p>;

    return (
        <div>
            <h2>Gallery</h2>
            <div>
                {
                    data.getImages.map(image => {
                        const imageLink = "http://localhost:8080" + image.downloadLink;
                        return <div className={"ui-icon-image"}><img src={imageLink} alt={"Image"}/></div>;
                    })
                }
            </div>
        </div>
    );
}

export default Gallery;