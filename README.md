# Projeto "007: Aposentadoria"
# Descrição Resumida do Projeto/Jogo
Este projeto envolveu a implementação de um jogo em espaço celular. Nossa equipe criou um jogo em que o jogador controla James Bond em uma aventura pelos mares. O objetivo de Bond é derrotar o inimigo final, mas, para isso, ele deve se preparar comprando armas e melhorando seu barco. A única forma de se obter novas armas é através dos mercados. Neles, Bond pode vender os peixes que pescou, conseguir dinheiro, e, assim, comprar novas varas de pescar, munição para sua arma, e armas novas. Já nas oficinas, Bond é capaz de recuperar seu barco, e melhorá-lo. O jogo acaba quando Bond derrota o inimigo final, ou quando ele próprio morre. 
# Equipe
* Bruno Monteiro Bonetti - 232488
* Felipe Gabriel Brabes da Silva - 247085
# Arquivo Executável do Jogo
[link](Bond.jar)
# Slides do Projeto
## Slides da Prévia
https://docs.google.com/presentation/d/1bxpYdvJqY_zDTqkzxlfMwgjFqRVFSbtaSZaTso2gOtQ/edit#slide=id.p
## Slides da Apresentação Final
https://docs.google.com/presentation/d/1GcxfNY83bkcVmuXPsRg-E4uivzM0lzeXo7li02k9kpw/edit#slide=id.g137ce74f1a0_0_65
# Diagramas
## Diagrama Geral da Arquitetura do Jogo
https://app.diagrams.net/#G1iTVkYncELxah4xoj4fVMcuEirW_yfokd (Não funciona - link enviado por email para Lucas Castro)

## Relatório de Evolução

> Em nossa primeira conversa, decidimos qual tipo de jogo gostaríamos: um jogo de aventura, em que nosso protagonista, James Bond, navegaria pelo mar pescando e derrotando inimigos. Também pensamos em cada detalhe conceitual de nosso jogo, como funcionaria o dinheiro, como os inimigos se movimentariam e dariam dano no Bond, tipos de armas, tipos de inimigos, características de cada mar, como funcionaria a movimentação de um mar a outro (Corrente Marítima), como seria a pesca, dentre outros. 
Na primeira reunião definimos as classes básicas que teríamos que fazer para começar nosso projeto. A princípio, faríamos as seguintes classes: Mapa, Mar, Componente, Bond, Barco, Mochila, Arma, Vara, Peixe, Venda, Oficina, Corrente, Controlador, InterfaceGráfica. 
Na reunião seguinte, percebemos que precisaríamos fazer algumas mudanças: criar novas classes como AppBond, Montador, Toolkit, Célula, Resposta; criar a interface Item (usada por Arma, Vara e Peixe); criar a até então interface Componente (extendida por Individuo, Mercado, Oficina, Corrente).
Então, começamos a programar. Muitos problemas surgiram durante esse processo, e novas classes e melhorias em nossa arquitetura tiveram que serem feitas. Dentre elas, percebemos no meio da produção do projeto que seria de melhor proveito se Componente fosse agora uma classe abstrata, pois existiam diversos métodos comuns com a mesma implementação entre as classes herdeiras, para fazer bom re-uso do código e torná-lo de mais fácil manutenção, optamos pela troca.

>Enfrentamos muitas dificuldades durante o projeto: erros bobos, como chaves colocadas no lugar errado, chamada de funções equivocadas; problemas com debug; aprender a fazer interface gráfica e como coordenar qual painel iria aparecer em cada momento. O maior contratempo do projeto foi apenas descoberto nos últimos dias até a entrega final, o que acabou levando-nos a deixar de lado o acabamento do projeto. Essa grande dificuldade era, sem sombra de dúvidas, a maneira em que coordenaríamos o Controle. Até realmente nos depararmos com esse contratempo, tinhamos idealizado apenas uma classe de controle, uma que fizesse a leitura do teclado com o Scanner() (já utilizado no lab05 - Wumpus). Após diversas tentativas frustradas de conseguir fazer o Controle funcionar optamos por refazê-lo do zero utilizando o javax.swing KeyListener() e criando diversas classes de controle para que fosse desacoplada a lógica da leitura do teclado da lógica que comanda o jogo. Com isso a ideia de Desconectar e Conectar o controle ativo no leitor, criando as diversas classes necessárias para fazer cada controle específico das diversas fases do jogo: Mercado, oficina, inventário e o jogo em si. Embora que a solução para nós tenha sido elegante, é fato que a demanda de tempo até encontrar essa solução foi grande (tempo que poderia ser utilizado nos toques finais do jogo). Após essa solução decidimos fazer o mesmo com os JPanels da interface gráfica, e o resultado foi positivo.

> O último dos rearranjos de código foi realmente a mudança em como acessavamos as pastas internas ao jogo para que fosse possível criar o executável .jar do jogo.

# Destaques de Código

## Uso de CSV's
> Fazemos uso de dois CSV's para criar todo o mapa de nosso jogo. No item.csv, definimos quais peixes estarão presentes em cada mar, juntamente com a probabilidade de pescar cada um deles, e quais armas e varas estarão disponíveis no mercado daquele mar. Além disso, é definido todos os atributos destes itens (sendo o preço dos peixes, armas e varas, a durabilidade das varas, a munição das armas).
Já no componentes.csv, determinamos quantos inimigos terão em cada mar, assim como seu hp, dano e posição inicial, além de definir também onde estará o mercado e a oficina daquele mar. 
Acreditamos que é muito positivo a criação de nosso mapa por esses dois arquivos pois fica fácil fazer qualquer mudança nele.

### Código do destaque 
~~~java
AppBond.java
	String itens[][] = Toolkit.retrieveItems();
	String componentes[][] = Toolkit.retrieveComponents();
	Montador montador = new Montador();
	montador.montaMapa(componentes, itens);
~~~

## Tick
> Dentro da classe Resposta, temos o método tick. A cada tick do nosso jogo (ou seja a cada movimento, pesca ou tiro dado pelo Bond), checam-se alguns itens e executam-se algumas ações para que o programa continue funcionando. A lista de coisas checadas é: ver se o Bond morreu; ver se o Godzilla morreu; ver se os inimigos do mar atual morreram; verificar se Bond está sobre uma corrente marítima e enviá-lo para outro mar; fazer os inimigos do mar atual moverem em direção ao Bond; verificar se os inimigos estão próximos o suficiente para dar dano no Bond, e, se sim, fazê-lo. Essa classe é extremamente importante pois coordena toda a dinâmica do jogo. 

### Código do destaque 
~~~java
public void tick(GUIMar gRef) {
		
		if (bond.getHP() <= 0) {
			//verificando se Bond morreu
			…
		}else if(godzilla.getHP() <= 0) {
			//verificando se Godzilla morreu
			…
		}
		for(int i = 0; i<inimigosRestantes.length; i++) {
			//lógica para verificar se os inimigos do mar atual ainda estão vivos
			…
		}
		for(int i = 0; i<correntesMaritmas.length; i++) {
			//lógica para verificar se Bond está sobre alguma corrente marítima e mandá-lo para outro mar
			…
		}
		for(int i = 0; i<inimigosRestantes.length; i++) {
			//lógica para mover inimigos em direção ao Bond
		}
		for(int i = 0; i<inimigosRestantes.length; i++) {
			//lógica para fazer os inimigos darem dano no Bond
		}
	}
~~~

# Destaques de Orientação a Objetos

## Uso da classe abstrata componente na célula
> Era essencial para o grupo que cada célula do mar tivesse como armazenar os componentes visíveis nela, como o mercado, a oficina, Bond, inimigos ou nada. Para tanto garantimos que cada célula armazenasse um vetor de classes abstratas Componente, herdada por cada um dos componentes mencionados.
### Diagrama de Classes usada no destaque OO:
> Veja a [imagem](https://prnt.sc/BGKnutn90lhj) do diagrama.
### Código do Destaque OO
~~~java
// Código na classe Mar que associa à cada célula o componente durante a fase de montagem
	Mar.java

	public void associaCelula(Componente c, int x, int y) {
		if((x < 10)&&(y < 10)&&(x >= 0)&&(y >= 0)) {
			...
			celulas[x][y].adicionaComponente(c);
		}
	}
~~~

## Polimorfismo dos painéis na interface gráfica
> Como mencionado na aba do relatório de evolução, essa ideia ajudou a mostrar ao usuário a tela que ele precisa durante sua jogatina. A ideia é criar cada classe de painel para cada parte que precise de uma visualização específica, como no Mercado, que tem visualização diferente de o jogo no mar mesmo, por exemplo.
### Diagrama de Classes usada no destaque OO:
> Veja a [imagem](https://prnt.sc/7VaWoEckD5Cg) do diagrama.
### Código do Destaque OO
~~~java
// Depois de cada ação os painéis são pintados, sem que o frame saiba quais painéis estão sendo pintados, por meio do polimorfismo das classes de painéis criadas
	GUIMar.java

	public void actionPerformed(ActionEvent e) {
		leftPanel.repaint();
		rightPanel.repaint();
	}
~~~
~~~java	
// Utilizando painel generico como exemplo
public class PainelGenerico extends JPanel {
	...
	public void paintComponent(Graphics g) {
		//método a ser especificado para cada tipo de painel
	}
	...	
}	
~~~

## Polimorfismo dos Controles
> Como mencionado na aba do relatório de evolução, essa ideia foi um ponto crucial do nosso trabalho. Ela consiste em fazer o Leitor delegar ao controle ativo a tecla que ler, e fica no controle ativo a lógica a ser seguida a partir disso.
### Diagrama de Classes usada no destaque OO:
> Veja a [imagem](https://prnt.sc/BnTxXrlYLBJ7) do diagrama.
### Código do Destaque OO
~~~java
	Leitor.java
	...
	private Controle controleAtivo;
	...
	public void conectaControle(Controle control) {	
		this.controleAtivo = control;
	}
	...
	public void keyPressed(KeyEvent e){
		...
		if(!controleAtivo.interpreta(command, guiReference)) {
			System.out.println("acabou o jogo!");
		}
	}
~~~
~~~java	
	Controle.java
public interface Controle {
	public boolean interpreta(String comandos, GUIMar gRef);	
}	
~~~

## Polimorfismo dos tipos de arma
> Para acrescentar coisas modificaveis no projeto para tornar a experiência do jogador mais prazerosa, decidirmos criar varios tipos de armas. Para tanto, extendemos a classe Arma para os variados tipos de arma que criamos
### Diagrama de Classes usada no destaque OO:
> Veja a [imagem](https://prnt.sc/xIXOBgI_UpxY) do diagrama.
### Código do Destaque OO
~~~java
	Arma.java
	...
	public void atirar(Mapa mapa, String movimento, int x, int y) {
		//método a ser modificado para cada modo específico de atirar
	}
~~~

## Criando tipos de vara e inimigos através de herança
> Também com a intenção de adicionar mais detalhes ao jogo, e tornar a experiência mais prazerosa, criamos dois tipos de varas (Vara e VaraSorte), e dois tipos de inimigos (Inimigo e Tanque).

### Código do Destaque OO
~~~java
	public class VaraSorte extends Vara{
		...
	}
~~~
~~~java
	public class Tanque extends Inimigo{
		...
	}
~~~


# Destaques de Pattern

## Uso do Singleton

> Usamos Singleton tanto para Bond quanto para Resposta, Mapa e Leitor, pois entendemos que são classes extremamente importantes para o funcionamento do jogo, que conversam com diversos componentes e que não devem ter mais que uma instância.

### Código do Pattern
~~~java
public class Bond extends Individuo{
	
	private static final Bond instance = new Bond ();
    …
}
~~~
~~~java
public class Resposta {
	
	private static final Resposta instance = new Resposta();
    …
}
~~~
~~~java
public class Mapa {

	private static final Mapa instance = new Mapa ();
    …
}
~~~
~~~java
public class Leitor extends KeyAdapter {

	private static final Leitor instance = new Leitor();
    …
}
~~~

## Uso do strategy na classe de controle

> Usamos o strategy na lógica de controle do nosso jogo pois cada tipo de controle continha algoritmos específicos para cada tipo de controle. Por exemplo, a classe inventario trabalha com as teclas numéricas para acessar itens e equipá-los enquanto o controle do jogo em si trabalha com wasd para movimentação, etc.
### Diagrama do pattern:
> Veja a [imagem](https://prnt.sc/BnTxXrlYLBJ7) do diagrama.
### Código do Pattern
~~~java
// Leitor.java seria, de acordo com refactoring.guru, o que é chamado de contexto, e o controle ativo um objeto estratégia.
	Leitor.java
	...
	private Controle controleAtivo;
	...
	public void conectaControle(Controle control) {	
		this.controleAtivo = control;
	}
	...
	public void keyPressed(KeyEvent e){
		...
		if(!controleAtivo.interpreta(command, guiReference)) {
			System.out.println("acabou o jogo!");
		}
	}
~~~

~~~java
Controle.java
public interface Controle {
	public boolean interpreta(String comandos, GUIMar gRef);
	//esse é nosso strategy	
}	
~~~

# Conclusões e Trabalhos Futuros

> Por conta do tempo, e por focar em apresentar o jogo funcionando com a interface gráfica, deixamos algumas ideias de lado. Pensamos em melhorias diferentes para o barco do Bond, como dar dano ao entrar em contato com os inimigos, andar mais rapidamente pelo mar (através de um double ...), geração de mapas aleatórios, spawn de inimigos aleatórios, fazer inimigos atirarem, criar mais tipos de armas, varas, peixes, adicionar novas fases, fazer de fato o plano de exceções, melhorar a interface gráfica e fazer a movimentação dos barcos mais fluidas com a interface gráfica.

> Outra expansão que passou batida mas poderia ser de grande proveito para o projeto seria a utilização do pattern Factory Method na classe Montador. Após vermos as apresentações dos outros grupos que utilizaram o pattern, percebemos que isso tornaria toda a lógica do montador mais organizada.

> Com a implementação de diversas fases e itens como desejamos, talvez seja de proveito gerar checkpoints para os quais Bond volta após ter seu barco afundado, limitando a frustração do jogador, e isso poderia ser feito implementando o pattern Memento nas classes inventário e Bond.

> Durante as apresentações, também observamos outra ideia muito interessante que poderia ser implementada no nosso projeto:  o jogador pode escolher as binds durante o jogo, por exemplo, um jogador prefere atirar com 1234 no lugar de ijkl, outro prefere andar pelas setas do teclado no lugar de wasd, e isso representaria uma mudança "quality of life" no nosso jogo.

> Outra mudança que seria de proveito do grupo seria uma maior implementação das interfaces providas e requeridas, aumentando assim a robustez e a expansibilidade do código, principalmente uma que fizesse a comunicação entre as classes de controle e as classes do model.

# Documentação dos Componentes

# Diagramas

## Diagrama Geral da Arquitetura do Jogo

>[Diagrama de classes do projeto](https://drive.google.com/file/d/1iTVkYncELxah4xoj4fVMcuEirW_yfokd/view?usp=sharing) 

> Descrição breve:
>> Basicamente temos o diagrama o View que mostra as informações relevantes ao jogador na interface gráfica ao interagir com o Model, e inicia o jogo, com isso o leitor por meio do KeyLister lê o teclado e manda as alterações necessárias para o Model, que contém o mapa montado pela classe Montador, esse por sua parte é atualizado e faz as mudanças de resposta (fase dos inimigos) e o view é atualizado. Com isso temos o funcionamento do jogo, lembrando que a classe controle vai alterando seu modo de interpretar os comandos do teclado assim como alterar quais painéis do view estão ativamente sendo mostrados ao jogador.

## Diagrama Geral de Componentes

> Embora não tenhamos uma comunicação de interfaces entre os componentes, vamos detalhar um pouco os 3 principais componentes utilizados no projeto: Model, View e Control.

[Este é o diagrama com os componentes MVC](https://prnt.sc/AdHokidB6Vjk)

## Componente `View`

> Resumidamente, o componente View é responsável por mostrar na interface gráfica as partes relevantes do jogo para que o jogador possa ver o estado do jogo e agir de acordo com as possibilidades.

[Componente](https://prnt.sc/fjFYWnGKbG9Y)

*Ficha Técnica*
item | detalhamento
----- | -----
Classe | `pt.labfinal.view`
Autores | `Bruno e Felipe`
Interfaces | `---`

## Componente `Control`

> Resumidamente, o componente control é responsável por ler o teclado e, de acordo com o controle ativo, pedir que o model faça as alterações necessárias para seguir o andamento do jogo. Ele também pode ser o responsável pela alteração dos painéis ativos no view, por exemplo, se Bond pede para entrar no mercado e existe um mercado em sua célula, a tela principal é alterada pela tela do mercado.

[Componente](https://prnt.sc/w16QtmwxYrDB)

*Ficha Técnica*
item | detalhamento
----- | -----
Classe | `pt.labfinal.control`
Autores | `Bruno e Felipe`
Interfaces | `Controle`

## Componente `Model`

> Resumidamente, o componente model contém toda a lógica do jogo, como o mapa, o bond, os itens, os inimigos, etc.
> Essencialmente ele que rege as "regras" do jogo e controla as mais variadas partes do mesmo. É, na essência, o jogo em si.

[Componente](https://prnt.sc/oZVo3s_9223j)

*Ficha Técnica*
item | detalhamento
----- | -----
Classe | `pt.labfinal.model`
Autores | `Bruno e Felipe`
Interfaces | `---`

## Detalhamento das Interfaces

### Interface `Item`

Serve como base para todos os itens que estarão no inventário do Bond.

~~~java
public interface Item {
	public String getNome();
	public String getImage();
	public int getPreco();
}
~~~

Método | Objetivo
-------| --------
String getNome | Retorna o nome do item.
String getImage | Retorna a String com arquivo .png da imagem do item.
Int getPreco | Retorna o preço do item.

### Interface `Controle`

Serve como base para os diferentes tipos de Controle que temos.

~~~java
public interface Controle {
	
	public boolean interpreta(String comandos, GUIMar gRef);	
	
}
~~~

Método | Objetivo
-------| --------
boolean interpreta | Cada tipo de controle interpretará os comandos do teclado de maneira diferente.

# Plano de Exceções
## Diagrama da hierarquia de exceções
>Você pode acessar a hierarquia [aqui](https://prnt.sc/5M8lVP8faaFd)

## Descrição das classes de exceção

Classe | Descrição
----- | -----
AcaoException | Engloba todas as exceções que podem ocorrer na fase de ação (controle do jogador)
SemArmaException | Indica que não existe arma ativa para atirar.
SemAtivoException | Indica que o item que quer acessar não está ativo, exemplo: querer atirar sem arma ativa.
SemControleException | Indica que o controleAtivo na classe Leitor é null, logo não existe "resposta" para os comando do jogador.
SemDinheiroException | Indica que Bond não tem dinheiro suficiente para esta compra.
SemVaraException | Indica que a não existe vara ativa para pescar.
PosicaoInvalidaException | Indica que a posição de Bond está incorreta.
RespostaException | Engloba todas as exceções que podem ocorrer na fase de resposta (controle dos inimigos)
MoveIndividuoException | Indica erro na movimentação do inimigo na fase de resposta
WallColisionException | Indica que um indivíduo tentou acessar uma célula fora da matriz de células
TrocaMapaException | Indica que não há outro mapa para trocar (temos apenas mapas de 0  a 5)
BondCollisionException | Indica que existe outro indivíduo na mesma célula que Bond
