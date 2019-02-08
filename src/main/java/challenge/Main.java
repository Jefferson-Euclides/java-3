package challenge;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	ProcessaArquivo processaArquivo = new ProcessaArquivo();

	List<Jogador> listaJogadores = processaArquivo.retornaListaRegistros();

	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public int q1() {
		return ((int) listaJogadores.stream()
				.map(Jogador::getNationality)
				.distinct()
				.count());
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {
		return ((int) listaJogadores.stream()
				.filter(jogador -> !jogador.getClub().isEmpty())
				.map(Jogador::getClub)
				.distinct()
				.count());
	}

	// Liste o primeiro nome (coluna `full_name`) dos 20 primeiros jogadores.
	public List<String> q3() {
		return listaJogadores.subList(0, 20).stream()
				.map(Jogador::getFullName)
				.collect(Collectors.toList());
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	public List<String> q4() {
		return listaJogadores.stream()
				.filter(jogador -> jogador.getEurReleaseClause() != null)
				.sorted(Comparator.comparing(Jogador::getEurReleaseClause).reversed())
				.map(Jogador::getFullName)
				.limit(10)
				.collect(Collectors.toList());
	}

	// Quem são os 10 jogadores mais velhos (use como critério de desempate o campo `eur_wage`)?
	// (utilize as colunas `full_name` e `birth_date`)
	public List<String> q5() {
		return listaJogadores.stream()
				.sorted(Comparator.comparing(Jogador::getBirthDate)
						.thenComparing(Jogador::getEurWage))
				.map(Jogador::getFullName)
				.limit(10)
				.collect(Collectors.toList());
	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	public Map<Integer, Integer> q6() {
		HashMap<Integer, Integer> mapaJogadores = new HashMap<>();
		
		 listaJogadores.stream()
				.collect(Collectors.groupingBy(Jogador::getAge, Collectors.counting()))
		                 .entrySet()
				.iterator()
				.forEachRemaining(jogador -> mapaJogadores.put(Integer.parseInt(jogador.getKey().toString()), Integer.parseInt(jogador.getValue().toString())));
		 
		 return mapaJogadores;
	}
	
	public static void main(String[] args) {
		
		
		Main main = new Main();
		
		System.out.println(main.q1());
	}
}
