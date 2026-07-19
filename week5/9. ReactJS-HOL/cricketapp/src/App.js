import {
  OddPlayers,
  EvenPlayers,
  ListofIndianPlayers
} from "./IndianPlayers";

function App() {

  const flag = false;

  const T20Players = [
    "Sachin",
    "Dhoni",
    "Virat"
  ];

  const RanjiPlayers = [
    "Rohit",
    "Gill",
    "Rahul"
  ];

  const IndianPlayers = [...T20Players, ...RanjiPlayers];

  const [first, second, third, fourth, fifth, sixth] = IndianPlayers;

  if (flag) {

    return (
      <div>
        <h1>Flag is True</h1>
      </div>
    );

  }

  return (
    <div>

      <h1>Odd Players</h1>

      <OddPlayers
        first={first}
        third={third}
        fifth={fifth}
      />

      <hr />

      <h1>Even Players</h1>

      <EvenPlayers
        second={second}
        fourth={fourth}
        sixth={sixth}
      />

      <hr />

      <h1>Indian Players Merged</h1>

      <ListofIndianPlayers IndianPlayers={IndianPlayers} />

    </div>
  );

}

export default App;