    function print_voucher(canvasId){
    	var canvas=document.getElementById(canvasId);
        var win=window.open();
        win.document.write("<br><img src='"+canvas.toDataURL()+"'/>");
        win.print();
        win.location.reload();
        win.close();
	}
  