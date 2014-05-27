<%-- 
    Documento : mostraDados
    Criação   : 26/08/2010, 15:15:20
    Autor     : Eduardo Comin
--%>

<%@page import="dados.Avaliacao"%>
<%@page import="dao.AvaliacaoDAO"%>
<%@page import="java.util.List"%>


<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="conexao.Conecta"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="css/bootstrap.css">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Listagem de dados de Clientes</title>
    </head>
    <body>
        
        <%
            String msg_exc = request.getParameter("codExcluido");
            if (msg_exc != null) {
                out.println("<h3>Cliente: <strong>"+msg_exc+"</strong> foi excluído com sucesso</h3>");
            }
            
            String msg = request.getParameter("nomeIncluido");
            if (msg != null) {
                out.println("<h3>Cliente: <strong>"+msg+"</strong> foi incluído com sucesso</h3>");
            } else {
                msg = request.getParameter("erro");
                if (msg != null) {
                   out.println("<h3>Erro: <strong>"+msg+"</strong> ao incluir cliente</h3>"); 
                }
            }
            
            out.println("<h1>Pesquisa</h1>");
            out.println("<h2>TDC 2014</h2>");
        
            
        // Definido o Statement, executamos o comando no banco de dados.

            out.println("<table border=2px cellpadding=5px cellspacing=0>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Código</th>");
            out.println("<th>Nome</th>");
            out.println("<th>Trilha</th>");
            out.println("<th>Avaliacao</th>");
            out.println("<th>Excluir</th>");
            out.println("</thead>");
            AvaliacaoDAO clienteDao = new AvaliacaoDAO();
            List<Avaliacao> lista = clienteDao.getAvaliacoes();
            int nregistros = lista.size();
            for (Avaliacao cliente: lista) {



            // caso existir resultados, percorremos a lista.



                //Exibir os dados na tela.
                out.println("<tr>");
                out.println("<td align='center'>" + cliente.getCodigo() + "</td>");
                out.println("<td>" + cliente.getNome_pessoa()+ "</td>");
                out.println("<td>" + cliente.getTrilha().getNometrilha() + "</td>");
                out.println("<td>" + cliente.getAvaliacao() + "</td>");

                //link para exclusão
                out.println("<td><form name=\"excluirForm\" action=\"ServletExcluirCliente\" method=\"POST\">");
                out.println("<input type=\"hidden\" name=\"codigo\" id=\"codigo\" value=\""+cliente.getCodigo()+"\"/>");
                out.println("<input type=\"submit\" value=\"Excluir >>\" name=\"btServletExcluir\" id=\"btServletExcluir\" />");
                out.println("</form></td>");

                out.println("</tr>");
                nregistros++;
            }

            out.println("</tbody>");
            out.println("</table>");
            out.println("<br />");
            out.println("<br />Foram encontrados " + nregistros + " registros<br />");

                
            out.println("<a href=\"index.jsp\">Voltar</a> <br />");
            %>
    </body>
</html>
