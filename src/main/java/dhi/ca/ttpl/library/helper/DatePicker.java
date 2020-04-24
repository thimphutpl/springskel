
package dhi.ca.ttpl.library.helper;

import java.io.Serializable;
/**
 * Created by jigme.dorji on 23/04/2020.
 */
public final class DatePicker implements Serializable {

    private static final long serialVersionUID = -228406150161128955L;
    //region private variables
    private int years;
    private int months;
    private int days;
    //endregion

    //region empty constructor
    public DatePicker() {
    }
    //endregion

    //region parameter constructor
    public DatePicker(int years, int months, int days) {
        this.years = years;
        this.months = months;
        this.days = days;
    }
    //endregion

    //region getter and setter
    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
    //endregion

}
