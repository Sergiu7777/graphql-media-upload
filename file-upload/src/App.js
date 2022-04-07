import {
    Route,
    NavLink,
    HashRouter, Routes
} from "react-router-dom";
import Home from "./component/Home";
import Upload from "./component/Upload";
import Gallery from "./component/Gallery";
import Contact from "./component/Contact";

import {
    ApolloClient,
    InMemoryCache,
    ApolloProvider,
    useQuery,
    gql
} from "@apollo/client";

const client = new ApolloClient({
    uri: 'http://localhost:8080/graphql',
    cache: new InMemoryCache()
});

const App = () => {
    return (
        <ApolloProvider client={client}>
            <HashRouter>
                <div>
                    <h1>Image Gallery</h1>
                    <ul className="header">
                        <li><NavLink to="/">Home</NavLink></li>
                        <li><NavLink to="/upload">Upload image</NavLink></li>
                        <li><NavLink to="/gallery">Gallery</NavLink></li>
                        <li><NavLink to="/contact">Contact</NavLink></li>
                    </ul>
                    <div className="content">
                        <Routes>
                            <Route exact path="/" element={<Home/>}/>
                            <Route path="/upload" element={<Upload/>}/>
                            <Route path="/gallery" element={<Gallery/>}/>
                            <Route path="/contact" element={<Contact/>}/>
                        </Routes>
                    </div>
                </div>
            </HashRouter>
        </ApolloProvider>
    );
}

export default App;