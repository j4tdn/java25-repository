package java25.com.view;

import java25.com.connection.DbConnection;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Connection" + DbConnection.getConnection() );
    }
}
