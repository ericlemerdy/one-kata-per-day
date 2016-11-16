How to run tests ?
==================

With Docker, you can download the official node container and run tests inside.

    docker run -it --rm \
        -v $(pwd):/sources \
        -e "HOME=/sources" \
        --user 1000:1000 \
        -w /sources \
        node \
        /bin/bash

And then in the container :

    npm install
    npm run test