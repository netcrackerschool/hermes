package com.hermes.domain.places;

import com.hermes.domain.milestones.FinishMilestone;
import com.hermes.domain.milestones.StartMilestone;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 *  26.10.15.
 */
@Entity
@DiscriminatorValue("ABSTRACT_BASE")
public abstract class AbstractBase extends AbstractPlace {

    @OneToMany(mappedBy = "startBase")
    protected List<StartMilestone> milestonesFrom;

    @OneToMany(mappedBy = "finishBase")
    protected List<FinishMilestone> milestonesTo;

    AbstractBase() {
    }

    AbstractBase(String name) {
        super(name);
    }

    public List<StartMilestone> getMilestonesFrom() {
        return milestonesFrom;
    }

    public List<FinishMilestone> getMilestonesTo() {
        return milestonesTo;
    }
}
