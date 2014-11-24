package net.phutee.data.domain;


/**
 * Basic container object to populate weekly stats
 * @author sid
 */
public class Team {

    private String name;
    private String played;
    private String goalDiff;
    private String points;
    private String form;
    

    public Team(String name) {
	super();
	this.name = name;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Team [name=").append(name).append(", played=")
		.append(played).append(", goalDiff=").append(goalDiff)
		.append(", points=").append(points).append(", form=")
		.append(form).append("]");
	return builder.toString();
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
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
	Team other = (Team) obj;
	if (name == null) {
	    if (other.name != null)
		return false;
	}
	else if (!name.equals(other.name))
	    return false;
	return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayed() {
        return played;
    }

    public void setPlayed(String played) {
        this.played = played;
    }

    public String getGoalDiff() {
        return goalDiff;
    }

    public void setGoalDiff(String goalDiff) {
        this.goalDiff = goalDiff;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }
    
    
    
}
