import React from 'react';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import Slide from '@material-ui/core/Slide';
import Button from '@material-ui/core/Button';
import { makeStyles } from '@material-ui/core/styles';
import { Alert, AlertTitle } from '@material-ui/lab';

const Transition = React.forwardRef(function Transition(props, ref) {
    return <Slide direction="up" ref={ref} {...props} />;
});

const useStyles = makeStyles((theme) => ({
    root: {
      width: '100%',
      '& > * + *': {
        marginTop: theme.spacing(2),
      },
    },
}));

const DialogSuccess = ({ open, handleClose }) => {

    const classes = useStyles();

    return (
        <div>
            <Dialog
            open={open}
            TransitionComponent={Transition}
            keepMounted
            onClose={handleClose}
            aria-labelledby="alert-dialog-slide-title"
            aria-describedby="alert-dialog-slide-description"
            >
                <DialogContent>
                <DialogContentText id="alert-dialog-slide-description">
                    <div className={classes.root}>
                        <Alert severity="success">
                            <AlertTitle>Se han guardado los datos con exito!</AlertTitle>
                        </Alert>
                    </div>    
                </DialogContentText>
                </DialogContent>
                <DialogActions>
                <Button onClick={handleClose} color="primary">
                    Aceptar
                </Button> 
                </DialogActions>
            </Dialog>
        </div>
    )
}

export default DialogSuccess;