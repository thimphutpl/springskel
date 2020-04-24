
package dhi.ca.ttpl.library.helper;

import java.math.BigDecimal;
import java.util.Comparator;
/**
 * Created by jigme.dorji on 23/04/2020.
 */
public class DropdownDTO {

    public static Comparator<DropdownDTO> sort = new Comparator<DropdownDTO>() {
        @Override
        public int compare(DropdownDTO o1, DropdownDTO o2) {
            return o1.getText().compareTo(o2.getText());
        }
    };
    //region private variables
    // TODO : can be reduce field by using object for value field
    private Integer value;
    private String text;
    private String id;
    private Short valueShort;
    private Integer valueInteger;
    private Character valueChar;
    private BigDecimal valueBigDecimal;
    //endregion

    //region empty constructor
    public DropdownDTO() {
    }
    //endregion

    //region parameter constructor
    public DropdownDTO(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public DropdownDTO(String text, Short valueShort) {
        this.text = text;
        this.valueShort = valueShort;
    }

    public DropdownDTO(String text, Integer valueInteger) {
        this.text = text;
        this.valueInteger = valueInteger;
    }

    public DropdownDTO(Character valueChar, String text) {
        this.valueChar = valueChar;
        this.text = text;
    }
    public DropdownDTO(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public DropdownDTO(BigDecimal valueBigDecimal, String text) {
        this.valueBigDecimal = valueBigDecimal;
        this.text = text;
    }
    //endregion

    //region setter and getter


    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Short getValueShort() {
        return valueShort;
    }

    public void setValueShort(Short valueShort) {
        this.valueShort = valueShort;
    }

    public Integer getValueInteger() {
        return valueInteger;
    }

    public void setValueInteger(Integer valueInteger) {
        this.valueInteger = valueInteger;
    }

    public Character getValueChar() {
        return valueChar;
    }

    public void setValueChar(Character valueChar) {
        this.valueChar = valueChar;
    }

    public BigDecimal getValueBigDecimal() {
        return valueBigDecimal;
    }

    public void setValueBigDecimal(BigDecimal valueBigDecimal) {
        this.valueBigDecimal = valueBigDecimal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    //endregion

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((text == null) ? 0 : text.hashCode())
                + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        DropdownDTO other = (DropdownDTO) obj;

        // text
        if (text == null) {
            if (other.text != null)
                return false;
        } else if (!text.equals(other.text))
            return false;

        //value
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;

        return true;
    }
}
