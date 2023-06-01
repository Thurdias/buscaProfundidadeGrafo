import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Grafo {
	/// Propriedades da classe
	private int[][] matriz = null;

	// Método construtor da classe
	public Grafo(int qtdVertices) {
		matriz = new int[qtdVertices][qtdVertices];
	}

	// Métodos da classe
	public void construir() {
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));

		try {
			for (int i = 0; i < (matriz.length - 1); i++) {
				for (int j = i + 1; j < (matriz.length); j++) {
					System.out.print("Digite <S> se " + i + " tem conexão com " + j + ": ");
					if (leitor.readLine().equalsIgnoreCase("S")) {
						matriz[i][j] = 1;
						matriz[i][j] = 1;
					}
				}
			}
		} catch (Exception erro) {
			System.out.println(erro);
		}
	}

	private boolean procurarPercursoRecursivo(boolean visitado[], int inicio, int fim) {
		boolean retorno = false;

		if (inicio == fim) {
			retorno = true;
		} else {
			visitado[inicio] = true;

			for (int vizinho = 0; vizinho < matriz.length; vizinho++) {
				if ((matriz[inicio][vizinho] == 1) && (!visitado[vizinho])) {
					if (procurarPercursoRecursivo(visitado, vizinho, fim)) {
						retorno = true;
						System.out.print(vizinho + " <- ");
						break;
					}
				}
			}
		}
		return retorno;
	}
	
	public boolean procurarPercurso(int inicio, int fim) {
		boolean[] visitado = new boolean[matriz.length];
		boolean encontrei = false;
		
		encontrei = procurarPercursoRecursivo(visitado, inicio, fim);
		
		System.out.println(inicio);
	
		return encontrei;
	}
	
	public void imprimirConexoes() {
		for(int i = 0; i< matriz.length; i++) {
			System.out.print(i + ":\t ");
			for (int j = 0; j < matriz.length; j++){
				if (matriz[i][j] == 1) {
					System.out.print(j + "\t");
				}
			}
			System.out.println();
		}
	}
}
