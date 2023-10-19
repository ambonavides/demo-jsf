#!/bin/bash

path_sqs=/c/ambiente/ferramentas/kit-sqs-sns/
path_redis=/c/ambiente/ferramentas/redis/

x="teste"
menu () {
    while true $x != "teste"
    do
        clear
        echo "================================================"
        echo "================ DOCKER FAKE! =================="
        echo "================================================"
        echo ""
        echo "1) Iniciar o ElasticMQ"
        echo""
        echo "2) Criar fila"
        echo ""
        echo "3) Iniciar Redis"
        echo""
        echo "0) Sair do programa"
        echo ""
        echo "================================================"

        echo "Digite a opção desejada: "
        read x
        echo "Opção informada ($x)"
        echo "================================================"

        case "$x" in
                1)
                echo "Iniciando fila..."
                "$path_sqs"jdk/bin/java.exe -jar "$path_sqs"elasticmq-server-1.4.2.jar & 
                read 
                echo "================================================"
            ;;
                2)
                echo "Criando fila..."
                node "$path_sqs"index.js
                read 
            echo "================================================"
            ;;
            3)
                echo "Iniciando redis..."
                #cd "$path_redis" && ./start-redis-local.bat &
                cd "$path_redis"
                jdk/bin/java.exe -jar redisclient.jar & 
                ./redis-server.exe redis.conf &

                read 
            echo "================================================"
            ;;
                0)
                    echo "saindo..."
                    sleep 5
                    clear;
                    exit;
            echo "================================================"
            ;;

            *)
                    echo "Opção inválida!"
        esac
    done
}

menu


