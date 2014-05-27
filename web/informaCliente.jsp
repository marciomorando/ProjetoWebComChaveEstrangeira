<%-- 
    Documento : mostraDados
    Criação   : 26/08/2010, 15:15:20
    Autor     : Eduardo Comin
--%>

<%@page import="dados.Trilha"%>
<%@page import="dao.TrilhaDAO"%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="css/bootstrap.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Avaliacao A1/2</title>
    </head>
    <body>
        <h1><strong>Pesquisa de Satisfacao TDC 2014</strong></h1>

        <fieldset>

        <h3>Digite seu nome:</h3>
        <form name="resultadoForm" action="ServletAlimentaCliente" method="POST">
            
            <label for="nome">Nome:</label><br />
            <input type="text" name="nome" id="nomepessoa" value="" size="60" /><br />
          
            <br />
            <select name="trilha">
                <%
                TrilhaDAO categoriaDao = new TrilhaDAO();
                for (Trilha categoria: categoriaDao.getTrilhas()) {
                    out.print("<option value=\""+categoria.getCodigo()+"\">"+categoria.getNometrilha()+"</option>");
                }
                %>
            </select>
            
              <fieldset><legend>Avaliação:</legend>
                Otima<input type="radio" id="avaliacao" name="avalia" value="otima" />
                Boa<input type="radio" id="avaliacao" name="avalia" value="boa" /><br />
                Regular<input type="radio" id="avaliacao" name="avalia" value="regular" />
                Ruim<input type="radio" id="" name="avalia" value="ruim" /><br />
            </fieldset>
            
            <br /><br /><br />
            <input type="submit" value="Incluir >>" name="btServlet" id="btServlet" />
        </form>
        </fieldset>
        <hr>
        <br />
        
        
        
        <form name="frmDelete" action="ExcluirServlet" method="POST">
            <input type="hidden" name="codigo" id="codigo" value="" />
        </form>


        <a href="index.jsp">Voltar</a> <br />
    </body>
</html>
