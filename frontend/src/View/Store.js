import React , { useState, useEffect } from 'react';
import ListProduct from './ListProduct';
import DialogAddProduct from './DialogAddProduct';
import { getStoreByIdUserRequest } from '../Service/Api';
import CssBaseline from '@material-ui/core/CssBaseline';
import Container from '@material-ui/core/Container';
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  paper: {
    padding: theme.spacing(2),
    textAlign: 'center',
    color: theme.palette.text.secondary,
  },
}));

const Store = () => {

  const classes = useStyles();
  const [ id, setId ] = useState(null); 
  const [ name, setName ] = useState(null); 
  const [ products, setProducts] = useState(null);

  useEffect(() => {
      if(!id) {
      getStoreByIdUserRequest(1)
      .then(data => {
        console.log(data);
        const { id, name, products } = data;
        setId(id);
        setName(name);
        setProducts(products);
      })
      .catch(error => {
        console.log(error);
      })
    }

  }, [])

    return (
      <React.Fragment>
      <CssBaseline />
      <Container fixed>
        <div className={classes.root}>
      <Grid container spacing={2}>
        <Grid item xs={12}>
          <Paper className={classes.paper}>{name}</Paper>
        </Grid>
        <Grid item xs={12}>
          <DialogAddProduct setProducts={setProducts} />
        </Grid>
        { products  &&
            <ListProduct products={products} idStore={id}/>
        }     
      </Grid>
      </div>
      </Container>
    </React.Fragment>
    )
}

export default Store;
