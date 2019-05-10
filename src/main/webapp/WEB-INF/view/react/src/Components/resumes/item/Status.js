import React from "react";

const Status = (props) => {
    switch (props.status) {
        case 0:
            return (
                <div>
                    Inactive
                </div>
            );
        case 1:
            return (
                <div>
                    Active
                </div>
            );
        case 2:
            return (
                <div>
                    Unsent
                </div>
            );
        case 3:
            return (
                <div>
                    Rejected
                </div>
            );
        case 4:
            return (
                <div>
                    Admitted
                </div>
            );
        case 5:
            return (
                <div>
                    Pending
                </div>
            );
        default: {
            return (
                <div>
                    Unrecognized
                </div>
            );
        }
    }
};

export default Status;