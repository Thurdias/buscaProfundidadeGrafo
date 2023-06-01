import java.io.BufferedReader;
import java.io.InputStreamReader;

public class principal {
	public static void main(String[] args) {
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
		Grafo objGrafo = new Grafo(4);
		int inicio = 0;
		int fim = 0;
		
		try {
			objGrafo.construir();
			
			System.out.print("Digite o vértice inicial: ");
			inicio = Integer.parseInt(leitor.readLine());
			

			System.out.print("Digite o vértice final: ");
			fim = Integer.parseInt(leitor.readLine());
			
			objGrafo.procurarPercurso(inicio, fim);
		} catch(Exception erro) {
			System.out.println(erro);
		}
		
	}
}
