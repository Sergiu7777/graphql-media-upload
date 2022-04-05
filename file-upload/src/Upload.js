const {Component} = require("react");

class Upload extends Component {
    render() {
        return (
            <div>
                <h2>Upload image</h2>

                <div>
                    <input type="file"/>
                    <button type="button">Upload!</button>
                </div>

            </div>
        );
    }
}

export default Upload;