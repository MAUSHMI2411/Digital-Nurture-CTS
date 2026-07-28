import office from "./office.jpg";

function App() {

  const officeList = [
    {
      Name: "DBS",
      Rent: 50000,
      Address: "Chennai",
      Image: office
    },
    {
      Name: "TCS",
      Rent: 75000,
      Address: "Bangalore",
      Image: office
    },
    {
      Name: "Infosys",
      Rent: 55000,
      Address: "Hyderabad",
      Image: office
    }
  ];

  return (
    <div style={{ textAlign: "center" }}>

      <h1>Office Space, at Affordable Range</h1>

      {officeList.map((item, index) => (
        <div key={index}>

          <img
            src={item.Image}
            alt="Office Space"
            width="300"
          />

          <h2>Name: {item.Name}</h2>

          <h3
            style={{
              color: item.Rent <= 60000 ? "red" : "green"
            }}
          >
            Rent: Rs. {item.Rent}
          </h3>

          <h3>Address: {item.Address}</h3>

          <hr />

        </div>
      ))}

    </div>
  );
}

export default App;