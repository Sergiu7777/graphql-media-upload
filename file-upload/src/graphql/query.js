import {gql} from "@apollo/client";

export const GET_STRING = gql`
    query GetString {
        getString
    }`;