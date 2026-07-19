function ListofPlayers(props) {

    return (
        <div>
            {props.players.map((item) => (
                <div key={item.name}>
                    Mr. {item.name}
                    <span> {item.score}</span>
                </div>
            ))}
        </div>
    );

}

export default ListofPlayers;