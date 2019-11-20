/** Object to hold initial and final integers
  * @author Eric Han
  */
public class ValueHolder {
  
  /** Initial index */
  private int init;
  
  /** Final index */
  private int fin;
  
  /** Number of consecutive colors */
  private int count;
  
  /** Constructor for ValueHolder
    * @param init initial index
    * @param fin final index
    */
  public ValueHolder(int init, int fin) {
    this.init = init;
    this.fin = fin;
    this.count = fin - init + 1;  // Number of consecutive colors = final - init + 1
  }
  
  /**
   * Returns initial index
   * @return initial index
   */
  public int getInit() {
    return this.init;
  }
  
  /**
   * Returns final index
   * @return final index
   */
  public int getFin() {
    return this.fin;
  }
  
  /**
   * Returns consecutive colors
   * @return consecutive colors
   */
  public int getCount() {
    return this.count;
  }
}