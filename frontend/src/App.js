import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { publicRoutes } from './routes';
import { Fragment } from 'react';
import { Provider } from 'react-redux';
import { store } from './states/store';

function App() {
    return (
        <Router>
            <Provider store={store}>
                <div className="App">
                    <Routes>
                        {publicRoutes.map((route, index) => {
                            const Page = route.component;

                            let Layout = Fragment;
                            if (route.layout) {
                                Layout = route.layout;
                            }

                            return (
                                <Route
                                    key={index}
                                    path={route.path}
                                    element={
                                        <Layout>
                                            <Page />
                                        </Layout>
                                    }
                                />
                            );
                        })}
                    </Routes>
                </div>
            </Provider>
        </Router>
    );
}

export default App;
