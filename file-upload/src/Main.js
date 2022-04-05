import {
    Route,
    NavLink,
    HashRouter, Routes
} from "react-router-dom";
import Home from "./Home";
import Upload from "./Upload";
import Gallery from "./Gallery";
import Contact from "./Contact";

const {Component} = require("react");

class Main extends Component {
    render() {
        return (
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
                            <Route exact path="/" element={ <Home/> }/>
                            <Route path="/upload" element={ <Upload/> }/>
                            <Route path="/gallery" element={ <Gallery/> }/>
                            <Route path="/contact" element={ <Contact/> }/>
                        </Routes>
                    </div>
                </div>
            </HashRouter>
        );
    }
}

export default Main;