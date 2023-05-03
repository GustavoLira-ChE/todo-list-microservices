const path = require('path');

module.export = {
    entry: './src/idex.js',
    output: {
        path: path.resolve(__dirname,"dist"),
        filename: "bundle.js",
    },
    resolve: {
        extensions: ['.js','.jsx'], 
    },
    mode: 'development',
    devServer: {
        static: path.join(__dirname,"dist"),
        port: 3001,
        historyApiFallback: true,
    }
}