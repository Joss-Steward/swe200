package environment;

import lifeForm.LifeForm;

/**
 * A Cell that can hold a LifeForm.
 * Code sourced from Textbook
 * @author Joss Steward
 */
public class Cell
{
	LifeForm entity;
	
   /**
    * @return the LifeForm in this Cell.
    */
   public LifeForm getLifeForm()
   {
      return entity;
   }
   
   /**
    * Tries to add the LifeForm to the Cell.  
    * Will not add the LifeForm is the Cell isn't empty.
    * @return true if the LifeForm was added to the Cell, false otherwise. 
    */
   public boolean addLifeForm(LifeForm entity)
   {
	   if(this.entity == null)
	   {
		   this.entity = entity;
		   return true;
	   } else {
		   return false;
	   }
   }   
   
   /**
    * Removes the current LifeForm from the cell
    * @returns the removed LifeForm, if any. Null otherwise.
    */
   public LifeForm removeLifeForm()
   {
	   LifeForm temp = entity;
	   entity = null;
	   return temp;
   }
}
