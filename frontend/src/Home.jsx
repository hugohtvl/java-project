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
    <div id="homeGlobal">
      <h1>Ceci est un onepage avec un back Java !</h1>
      <div id="pokemonGlobal">
        {pokemons.map((pokemon) => (
          <div key={pokemon.id} id="pokemonCard">
            <p id="pokemonName">{pokemon.name}</p>
            <img src={pokemon.imgurl} />
            <div id="attackPower">
              <p>
                <span>Attaque favorite</span> {pokemon.attackName}
              </p>
              <p>
                <span>Puissance de l&apos;attaque</span> {pokemon.attackPower}
              </p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Home;
