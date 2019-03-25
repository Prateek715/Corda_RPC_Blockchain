This is the rpc end point protocol of corda.

Check the Initiator.java code and its endpoint at Responder.java

Initiator.java contains the Party and number as input.(Party, number);

Check the Responder.java. It checks whether input is greater than three on not. If not it will add +1 and send back to the output node Party.

Check the build.gradle and run its deploynodes test to build all the nodes.

output of build.gradle

Generating contract implementations whitelist
New NetworkParameters {
      minimumPlatformVersion=4
      notaries=[NotaryInfo(identity=O=Notary, L=London, C=GB, validating=false)]
      maxMessageSize=10485760
      maxTransactionSize=524288000
      whitelistedContractImplementations {

      }
      eventHorizon=PT720H
      packageOwnership {

      }
      modifiedTime=2019-03-25T11:12:19.184Z
      epoch=1
  }
Bootstrapping complete!

BUILD SUCCESSFUL in 1m 42s
11 actionable tasks: 11 executed
16:42:20: Task execution finished 'deployNodes'.


Under /build/nodes run ./runnodes


Output of command

Mon Mar 25 16:46:31 IST 2019>>> flow list
com.template.flows.Initiator
net.corda.core.flows.ContractUpgradeFlow$Authorise
net.corda.core.flows.ContractUpgradeFlow$Deauthorise
net.corda.core.flows.ContractUpgradeFlow$Initiate


Use the command start Initiator counterparty: PartyA , number: 2

 ✅   Starting
➡️   Done
Flow completed with result: 3




