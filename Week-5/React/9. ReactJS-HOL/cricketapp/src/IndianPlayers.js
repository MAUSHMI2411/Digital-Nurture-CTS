export function OddPlayers({ first, third, fifth }) {
  return (
    <div>
      <p>{first}</p>
      <p>{third}</p>
      <p>{fifth}</p>
    </div>
  );
}

export function EvenPlayers({ second, fourth, sixth }) {
  return (
    <div>
      <p>{second}</p>
      <p>{fourth}</p>
      <p>{sixth}</p>
    </div>
  );
}

export function ListofIndianPlayers({ IndianPlayers }) {
  return (
    <div>
      {IndianPlayers.map((player, index) => (
        <p key={index}>{player}</p>
      ))}
    </div>
  );
}