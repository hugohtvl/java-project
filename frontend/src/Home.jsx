import axios from "axios";
import { useEffect, useState } from "react";

function Home() {
  const [pokemons, setPokemons] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/pokemon/readallwithattack")
      .then((res) => setPokemons(res.data))
      .catch((error) => {
        console.error(
          "Une erreur s'est produite lors de la récupération des sujets.",

          error
        );
      });
  }, []);

  console.info(pokemons);

  return (
    <>
      <h1>Ceci est un onepage avec un back Java !</h1>
      <h2>oui il n&apos;y a que du get ...</h2>
      <div id="pokemonGlobal">
        {pokemons.map((pokemon) => (
          <div key={pokemon.id} id="pokemonCard">
            <p>{pokemon.name}</p>
            <img src={pokemon.imgurl} />
            <div id="attackPower">
              <p>{pokemon.attackName}</p>
              <p>{pokemon.attackPower}</p>
            </div>
          </div>
        ))}
      </div>
    </>
  );
}

export default Home;
