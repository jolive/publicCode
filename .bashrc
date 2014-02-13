#! /bin/bash

sourceIfFound()
{
   if [ -f $1 ]; then
      . $1
   fi
}

export PROJECTHOME=$PWD
sourceIfFound $PROJECTHOME/sdk/savetyping.sh

PATH=$PATH:$HOME/bin
export PATH

PS1="[\W]> "
export PS1

alias vd='ls -lap'


