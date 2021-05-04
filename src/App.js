import Body from "./components/Body";
import Header from "./components/Header";

process.title = "react_ui";
function App() {
  return (
    <div className="container">
      <Header />
      <Body />
    </div>
  );
}

export default App;
