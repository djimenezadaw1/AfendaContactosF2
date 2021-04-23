package agenda.io;

public class RelacionIntroducidaInexistente extends Exception{

	
	private String mensaje;

    /**
     * Constructor  
     */
    public RelacionIntroducidaInexistente(String mensaje)
    {
         this.mensaje = mensaje;
    }

	@Override
	public String getMessage()
	{
		return mensaje;
	}

    /**
     *  
     * 
     */
    @Override
	public String toString()
    {
         return mensaje;
    }
}
