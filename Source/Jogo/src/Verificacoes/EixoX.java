package Verificacoes;

public class EixoX implements Verificacao{

	@Override
	public boolean verificacao(char jogo[][]) {
		if(jogo[0][0]!='.'&&jogo[0][0]==jogo[0][1] && jogo[0][1]==jogo[0][2]) {
			return true;
		}else if(jogo[1][0]!='.'&&jogo[1][0]==jogo[1][1] && jogo[1][1]==jogo[1][2]){
			return true;
		}else if(jogo[2][0]!='.'&&jogo[2][0]==jogo[2][1] && jogo[2][1]==jogo[2][2]) {
			return true;
		}else {
			return false;
		}
	}
}
