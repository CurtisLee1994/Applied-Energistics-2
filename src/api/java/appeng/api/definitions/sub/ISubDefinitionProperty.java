
package appeng.api.definitions.sub;


public interface ISubDefinitionProperty<T, D, P>
{

	/**
	 * Checks whether value is a valid value.
	 * 
	 * @param value value to check
	 * @return Whether value is valid
	 */
	boolean isValid( P value );

}