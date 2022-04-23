import {gql} from "@apollo/client";

export const GET_IMAGE_BY_ID = gql`
    query GetImageById($fileId: String!) {
        getImageById(fileId: $fileId) {
            id
            fileName
            downloadLink
        }
    }
`;

export const GET_IMAGES = gql`
    query GetImages {
        getImages {
            id
            fileName
            downloadLink
        }
    }
`;