package Verificacoes;

public class Empate implements Verificacao {


	@Override
	public boolean verificacao(char jogo[][]) {
		byte cont=0;
		for(int i=0;i<jogo.length;i++) {
			for (int j =0; j<jogo.length;j++) {
				if(jogo[i][j] != '.') {
					cont++;
				}
			}
		}
		if(cont==9) {
			return true;
		}else {
			return false;
		}
	}
}
