module.exports = function(config) {

    config.addFilter("upperCase", function(value) {

        return value.toUpperCase();
    });


    return {
        dir: {
            input: './src', 
            output: './dist'
        }
    }
}