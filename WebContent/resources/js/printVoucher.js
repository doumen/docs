    function print_voucher(canvasId){
    	var canvas=document.getElementById(canvasId);
        var win=window.open();
        win.document.write("<br><img src='"+canvas.toDataURL()+"'/>");
        win.print();
        win.location.reload();
        win.close();
	}
  
    function print_grafico_doctos_assinantes(assinante,contabilidade,pieChart,lineChart,plano,consumo){
    	var win=window.open();
    	var cod = "";
    	cod += "<table>";
	    	cod += "<tbody>";
		    	cod += "<tr>";
			    	cod += "<td>";
			    		cod +="Assinante ";
			    	cod += "</td>";
			    	cod += "<td>";
			    		cod += assinante;
			    	cod += "</td>";
		    	cod += "</tr>";
		    	cod += "<tr>";
			    	cod += "<td>";    	
			    		cod +="Contabilidade ";
			    	cod += "</td>";
			    	cod += "<td>";
			    		cod += contabilidade;
			    	cod += "</td>";
	    	cod += "</tr>";
	    	cod += "</tbody>";
    	cod += "</table>";
    	cod += "<br><img src='"+PF(pieChart).exportAsImage().src+"'/>";
    	cod += "<img src='"+PF(lineChart).exportAsImage().src+"'/>";
    	cod += "<table>";
	    	cod += "<tbody>";
		    	cod += "<tr>";
			    	cod += "<td>";
			    		cod += "Plano Contratado ";
			    	cod += "</td>";
			    	cod += "<td>";
			    		cod += plano;
			    	cod += "</td>";
		    	cod += "</tr>";
		    	cod += "<tr>";
			    	cod += "<td>";    	
			    		cod +="Consumo Restante ";
			    	cod += "</td>";
			    	cod += "<td>";
			    		cod += consumo;
			    	cod += "</td>";
	    	cod += "</tr>";
	    	cod += "</tbody>";
	    cod += "</table>";
    	win.document.write(cod);
         win.print();
         win.location.reload();
         win.close();    	 
    }