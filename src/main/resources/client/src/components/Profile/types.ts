export type ProfileBase = {
    custFio: string,
    custId: string,
    custBirth: string,
    custInn: number,
} 

export type baseKeys = keyof ProfileBase;

export type ProfileLoan = {
    appId: number,
    appDate: string,
    credAmount: number,
    credTerm: number,
    credObject: string,
    custFio: string
}

export type loanKeys = keyof ProfileLoan;

export type ProfileIncome = {
    custFio: string,
    custMonthIncome: number,
    custFamilyMonthIncome: number,
    creditsCounts: number,
    creditSum: number
}

export type incomeKeys = keyof ProfileIncome


export type ProfileGuarantor = {
    guarantorFio: string,
    guarantorPhone: number,
    guarantorBirth: string,
}

export type guarantorKeys = keyof ProfileGuarantor;

export type ProfilePledge = {
    pledgeAmount: number,
    pledgeType: string,
}

export type pledgeKeys = keyof ProfilePledge;

export type CommonStatistics = {
    creditSum: number,
    clientNumber: number,
    guarantorPercent: number,
    middleIncome: number,
}

export type statisticsKeys = keyof CommonStatistics;

export enum DECISIONS {
    'APPROVE' = 'Система считает клиента надежным',
    'NOTHING' = 'Примите решенеие самостоятельно',
    'DENIED' = 'Система считает клиента ненадежным'
}