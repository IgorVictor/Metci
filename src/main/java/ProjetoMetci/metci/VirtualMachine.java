package ProjetoMetci.metci;

/**
 * Class to model a VM.
 */
public class VirtualMachine implements Comparable<VirtualMachine> {

    private String vmID;
    private Integer computerID;
    private NodePower power;
    private Long endTime;

    /**
     * Normal constructor.
     */
    public VirtualMachine() {}

    /**
     * Verify if the VM has finished its use.
     * @param timestamp actual time.
     * @return whether if the VM has finished its use, or not.
     */
    public boolean isFinished(long timestamp) {
        return timestamp >= endTime;
    }

    /**
     * Set VM ID.
     * @param id the object ID.
     * @return the VM itself for continuous setting.
     */
    public VirtualMachine setVmID(String id){
        this.vmID = id;
        return this;
    }

    /**
     * Get VM ID.
     * @return the object ID.
     */
    public String getVmID(){
        return this.vmID;
    }

    /**
     * Set computer ID, the one that create this VM.
     * @param id the ID of computer that creates this VM.
     * @return the VM itself for continuous setting.
     */
    public VirtualMachine setComputerID(int id){
        this.computerID = id;
        return this;
    }

    /**
     * Get computer ID, the one that create this VM.
     * @return the ID of computer that creates this VM.
     */
    public Integer getComputerID(){
        return this.computerID;
    }

    /**
     * Set power of this VM.
     * @param power the power of this VM.
     * @return the VM itself for continuous setting.
     */
    public VirtualMachine setPower(NodePower power){
        this.power = power;
        return this;
    }

    /**
     * Get power of this VM.
     * @return the power of this VM.
     */
    public NodePower getPower(){
        return this.power;
    }

    /**
     * Set the time to finish this VM usage.
     * @param time the time to finish this VM usage.
     * @return the VM itself for continuous setting.
     */
    public VirtualMachine setEndTime(long time){
        this.endTime = time;
        return this;
    }

    /**
     * Get the time to finish this VM usage.
     * @return the time to finish this VM usage.
     */
    public Long getEndTime(){
        return this.endTime;
    }

    public int compareTo(VirtualMachine other){
        return this.endTime.compareTo(other.endTime);
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        VirtualMachine that = (VirtualMachine) object;

        if (endTime != that.endTime) return false;
        if (vmID != null ? !vmID.equals(that.vmID) : that.vmID != null) return false;
        if (computerID != null ? !computerID.equals(that.computerID) : that.computerID != null) return false;
        if (power != null ? !power.equals(that.power) : that.power != null) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (vmID != null ? vmID.hashCode() : 0);
        result = 31 * result + (computerID != null ? computerID.hashCode() : 0);
        result = 31 * result + (power != null ? power.hashCode() : 0);
        result = 31 * result + (int) (endTime ^ (endTime >>> 32));
        return result;
    }
}
