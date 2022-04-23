import {gql} from "@apollo/client";

export const UPLOAD_IMAGE = gql`
    query UploadImage {
        uploadImage {
            title
        }
    }
`;