package bd;

//import bd.core.*;
//import bd.daos.*;
//import bd.dbos.*;

public class BDSQLServer
{
    public static final MeuPreparedStatement COMANDO;

    static
    {
    	MeuPreparedStatement comando = null;

    	try
        {
            comando =
            new MeuPreparedStatement (
            "com.microsoft.sqlserver.jdbc.SQLServerDriver",
            "jdbc:sqlserver://regulus:1433;databasename=BD18173",
            "BD18173", "raizesaereas18173");
        }
        catch (Exception erro)
        {
            System.err.println ("Problemas de conexao com o BD");
            System.exit(0); // aborta o programa
        }

        COMANDO = comando;
    }
}