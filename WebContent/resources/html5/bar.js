if (!bar)
	var bar = {}
if (!bar.js) {
		bar.js = {
			init : function(id, assinantes,maiorBarra,totalBarras,arrayCores,ordem) {
				// Variaveis internas
				var c = document.getElementById(id.id);
				c.width = window.innerWidth * 0.95;
				c.height = window.innerHeight * 0.5;
				var ctx = c.getContext("2d");
				var margin = 5;
				var	barWidth = (c.width - margin) / totalBarras - margin;
				var x = margin;
				var tx = x + barWidth / 2;
				var cores = arrayCores.split(",");				
				var titulo = 20;
				var texto = "";
				
				if(ordem>0)
					texto = 'Gráfico - Interação X Assinantes que mais Interagiram com o Sistema';
				else
					texto = "Gráfico - Interação X Assinantes que menos Interagiram com o Sistema";
				
				ctx.font = titulo + "px Georgia";
				var textWidth = ctx.measureText(texto).width;
				var textHeight = ctx.measureText(texto).height;
				ctx.fillText(texto, (c.width - 2 * margin - textWidth) / 2,
						margin + titulo);

				function stringInPxs(s,font){
					var ret = 0;
					ctx.save();
					ctx.font = font + "px Georgia";
					ret = ctx.measureText(texto).width;
					ctx.restore();
					return ret;
				}
				
				var pegaMaiorNomeAssinantes = function(assinantes) {
					ret = [];
					for (var i = 0; i < assinantes.length; i++) {
						ret[i] = assinantes[i]['nome'].length;
					}
					return Math.max.apply(Math, ret);
				}

				var maiorNomeAssinante = pegaMaiorNomeAssinantes(assinantes);

				var calculaFont = function() {
					return Math.min.apply(Math, [ 16, barWidth / 2,
							c.height / maiorNomeAssinante * 2 ]);
				}

				ctx.font = calculaFont() + "px Georgia";

				var pegaPropAssinantes = function(assinantes, prop) {
					var ret = [];
					for (var i = 0; i < assinantes.length; i++) {
						ret[i] = assinantes[i][prop];
					}
					return ret;
				};

				var totalDoctos = pegaPropAssinantes(assinantes, 'totalDoctos');

				var calculaEscalaVertical = function(c, totalDoctos) {
					//var nMax = Math.max.apply(Math, totalDoctos);
					return (c.height - 2 * margin - titulo * 1.4) / maiorBarra;
				};

				escala = calculaEscalaVertical(c, totalDoctos);

				var calculaBarHeight = function(totalDoctos, escala) {
					var ret = [];
					for (var i = 0; i < totalDoctos.length; i++) {
						ret[i] = totalDoctos[i] * escala;
					}
					return ret;
				}

				var barHeight = calculaBarHeight(totalDoctos, escala);

				var barras = [];
				function desenharBarras(){
				for (index = 0; index < assinantes.length; index++) {
					// Desenhar retangulos
					ctx.fillStyle = cores[index%(cores.length)];
					ctx.fillRect(x, c.height, barWidth,
							-assinantes[index]['totalDoctos'] * escala);
					var barra = {
							x:x,
							l:barWidth,
							h:assinantes[index]['totalDoctos'] * escala
					};
					barras.push(barra);
					// escrever assinantes nas barras

					ctx.save();
					ctx.fillStyle = "black";
					ctx.translate(tx, c.height);
					ctx.rotate(-Math.PI / 2);
					ctx.fillText(assinantes[index]['nome'], margin, margin);
					ctx.restore();

					//	
					tx = tx + barWidth + margin;
					x = x + barWidth + margin;
				}
				var tipCanvas = document.getElementById("tip");
				var tipFont = 11;
				tipCanvas.height = 3.5*tipFont;
				tipCanvas.width = c.width;
				var tipCtx = tipCanvas.getContext("2d");
				tipCtx.font = tipFont+"px Georgia";
				addEventListener("mousemove", listener);
				function listener(e){
					 var mX = e.clientX - c.offsetLeft - window.innerWidth * 0.013;
					 var mY = e.clientY - c.offsetTop;
					 var k = mouseNaBarra(mX,mY);
					 if(k>=0){
						 var ass = assinantes[k]; 
						 tipCtx.clearRect(0, 0, tipCanvas.width, tipCanvas.height);
						 tipCtx.fillText("Assinante: " + ass.nome, 5, tipFont);
						 tipCtx.fillText("Total Doctos: " + ass.totalDoctos, 5, 2.25*tipFont);
					 }else{
						 tipCtx.clearRect(0, 0, tipCanvas.width, tipCanvas.height);
					 }
				}
				function mouseNaBarra(mX,mY){
					for(var i=0;i<barras.length;i++){
						var barra = barras[i];
						if(mX>barra.x && mX<(barra.x+barra.l) && mY > (c.height - barra.h) ){
							return i;
						}
					}
					return -1;
				}

				}
				
				desenharBarras();
				
			}
		}
}