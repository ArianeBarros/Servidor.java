package controle.bd;

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
            System.err.println (erro);
            System.exit(0);
        }

        COMANDO = comando;
    }
}