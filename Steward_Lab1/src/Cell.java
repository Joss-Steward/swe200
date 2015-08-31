/**
 * A Cell that can hold a LifeForm.
 */
public class Cell
{
	LifeForm lifeForm;
	
   /**
    * @return the LifeForm in this Cell.
    */
   public LifeForm getLifeForm()
   {
      return lifeForm;
   }
   
   /**
    * Tries to add the LifeForm to the Cell.  
    * Will not add the LifeForm is the Cell isn't empty.
    * @return true if the LifeForm was added to the Cell, false otherwise. 
    */
   public boolean addLifeForm(LifeForm entity)
   {
	   if(lifeForm == null)
	   {
		   lifeForm = entity;
		   return true;
	   } else {
		   return false;
	   }
   }   
}
